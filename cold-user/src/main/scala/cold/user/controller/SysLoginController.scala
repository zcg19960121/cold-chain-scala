package cold.user.controller

import java.io.IOException
import cold.user.service.{SysUserService, SysUserTokenService}
import com.zhcg.cold.common.common.user.entity.{SysLoginForm, SysUserEntity}
import com.zhcg.cold.common.common.utils.Result
import org.apache.shiro.crypto.hash.Sha256Hash
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestBody, RequestHeader, RequestMapping, RestController}


/**
 * 登录相关
 *
 *
 */
@RestController
@RequestMapping("sys/user")
class SysLoginController @Autowired()(val sysUserService: SysUserService,val sysUserTokenService: SysUserTokenService) {

  /**
   * 登录
   */
  @PostMapping(Array("/login"))
  @throws[IOException]
  def login(@RequestBody form: SysLoginForm) = {
    //用户信息
    val user: SysUserEntity = sysUserService.queryByUserName(form.getUsername)
    //账号不存在、密码错误
    if (user == null || !(user.getPassword == new Sha256Hash(form.getPassword, user.getSalt).toHex)) {
      Result.error("账号或密码不正确")
    }
    //生成token，并保存到数据库
    val r: Result = sysUserTokenService.createToken(user.getUserId)
    r
  }

  /**
   * 退出
   */
  @PostMapping(Array("/logout")) def logout(@RequestHeader(value = "token") token: String): Result = {
    sysUserTokenService.logout(token)
    Result.ok
  }

  /**
   * 用户信息
   */
  @GetMapping(Array("/info")) def userInfo: Result = {
    val user: SysUserEntity = sysUserService.queryByUserName("admin")
    val map: java.util.Map[String, AnyRef] = new java.util.HashMap[String, AnyRef]
    map.put("name", user.getUsername)
    map.put("company", "传智播客")
    map.put("phone", "")
    map.put("avatar", "")
    map.put("username", user.getUsername)
    map.put("logintime", "")
    Result.ok(map)
  }


}
