package cold.user

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class UserApplication

object UserApplication extends App {
  SpringApplication.run(classOf[UserApplication], args: _*)

}
