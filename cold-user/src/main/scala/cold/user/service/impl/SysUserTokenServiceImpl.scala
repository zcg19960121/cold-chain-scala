package cold.user.service.impl

import java.util.Date

import cold.user.service.SysUserTokenService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.zhcg.cold.common.common.user.dao.SysUserTokenDao
import com.zhcg.cold.common.common.user.entity.SysUserTokenEntity
import com.zhcg.cold.common.common.utils.{Result, TokenGenerator}
import org.springframework.stereotype.Service


@Service("sysUserTokenService")
class SysUserTokenServiceImpl extends ServiceImpl[SysUserTokenDao, SysUserTokenEntity] with SysUserTokenService{
  //12小时后过期
  private val EXPIRE = 3600 * 12
  /**
   * 生成token
   *
   * @param userId 用户ID
   */
  override def createToken(userId: Long): Result = {
    //生成一个token
    val token = TokenGenerator.generateValue

    //当前时间
    val now = new Date
    //过期时间
    val expireTime = new Date(now.getTime + EXPIRE * 1000)

    //判断是否生成过token
    var tokenEntity = this.getById(userId)
    if (tokenEntity == null) {
      tokenEntity = new SysUserTokenEntity
      tokenEntity.setUserId(userId)
      tokenEntity.setToken(token)
      tokenEntity.setUpdateTime(now)
      tokenEntity.setExpireTime(expireTime)
      //保存token
      this.save(tokenEntity)
    }
    else {
      tokenEntity.setToken(token)
      tokenEntity.setUpdateTime(now)
      tokenEntity.setExpireTime(expireTime)
      //更新token
      this.updateById(tokenEntity)
    }

    val r = Result.ok.put("token", token).put("expire", EXPIRE)

    r
  }

  /**
   * 退出，删除token记录
   */
  override def logout(token: String): Unit = {
    this.getBaseMapper.deleteByToken(token)
  }
}
