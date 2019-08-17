package academy.learnprogramming.util.thymeleaf;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DecoupledLogicSetup {
    //fields
    private final SpringResourceTemplateResolver templateResolver;

    //constructor
    @Autowired
    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver){
        this.templateResolver = templateResolver;
    }

    //lifecyclemethods
    @PostConstruct
    public void init(){
        templateResolver.setUseDecoupledLogic(true);
        log.info("enabled decoupled template logic");
    }

}
