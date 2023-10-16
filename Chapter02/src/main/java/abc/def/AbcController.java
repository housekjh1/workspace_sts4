package abc.def;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbcController {

	public AbcController() {
		System.out.println("AbcController 생성자 호출");
	}
}
