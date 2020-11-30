package cold.user.service.impl

import cold.user.service.SysUserService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.zhcg.cold.common.common.user.dao.SysUserDao
import com.zhcg.cold.common.common.user.entity.SysUserEntity
import org.springframework.stereotype.Service


/**
 * 系统用户
 *
 *
 */
@Service("sysUserService")
class SysUserServiceImpl extends ServiceImpl[SysUserDao, SysUserEntity] with SysUserService {
  /**
   * 根据用户名，查询系统用户
   */
  override def queryByUserName(username: String): SysUserEntity = {
    baseMapper.queryByUserName(username);
  }
}
