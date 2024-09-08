package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello World");
        return "hello";
    }

    @GetMapping("hello-muxker")
    public String HelloMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-templates";
    }

    @GetMapping("/hello-fuxker")
    @ResponseBody
    public String HelloString(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-fuxker";
    }

    @GetMapping("/hello-world")
    @ResponseBody
    public Hello HelloSibalAPI(@RequestParam("name") String name) {
        Hello sss = new Hello();
        sss.setName(name);
        return sss;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
