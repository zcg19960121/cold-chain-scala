package cold.user.service

import com.baomidou.mybatisplus.extension.service.IService
import com.zhcg.cold.common.common.user.entity.SysUserEntity


trait SysUserService extends IService[SysUserEntity] {

  /**
   * 根据用户名，查询系统用户
   */
   def queryByUserName (username: String):SysUserEntity


}
