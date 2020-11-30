package cold.user.service

import com.baomidou.mybatisplus.extension.service.IService
import com.zhcg.cold.common.common.user.entity.SysUserTokenEntity
import com.zhcg.cold.common.common.utils.Result

/**
 * 用户Token
 *
 *
 */
trait SysUserTokenService extends IService[SysUserTokenEntity] {

  /**
   * 生成token
   *
   * @param userId 用户ID
   */
  def createToken(userId: Long): Result

  /**
   * 退出，删除token记录
   */
  def logout(token: String): Unit


}
