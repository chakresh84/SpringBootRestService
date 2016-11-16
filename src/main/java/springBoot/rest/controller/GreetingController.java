package springBoot.rest.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    @RequestMapping(value="/greetingPost", method=RequestMethod.POST)
    public String greetingPost(@RequestParam(value="name", defaultValue="World") String name) {
        return "hello post "+name;
    }
    
    @RequestMapping(value="/greetingXML",produces=MediaType.APPLICATION_XML_VALUE)
    public Employee greetingXML(@RequestParam(value="name", defaultValue="World") String name) {
        return new Employee(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/greetingPdf",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputStreamResource> getPdf() throws IOException {
        ClassPathResource pdfFile = new ClassPathResource("rent_leave_pune.pdf");
        
        return ResponseEntity.ok().contentLength(pdfFile.contentLength())
        		.contentType(MediaType.parseMediaType("application/octet-stream"))
        		.body(new InputStreamResource(pdfFile.getInputStream()));
        		
    }
}
