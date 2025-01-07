package day57;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

public class MVC {
}


// MVC1
class MVC1ViewContorller{ }
class MVC1Dao{}

// MVC2
class MVC2View{}
class MVC2Contoller{}
class MVC2Dao{}

// MVC2 3티어
// view : resource 안에 (html/css/js)존재
class MVC2tire3Controller{}
class MVC2tire3Service{}
class MVC2tire3Dao{}

//Spring MVC2 3tire
@RestController
class MVCController{}
@Service
class MVCService{}
@Component
class MVCDao{}