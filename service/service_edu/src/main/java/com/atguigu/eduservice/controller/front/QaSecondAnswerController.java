package com.atguigu.eduservice.controller.front;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.model.entity.QaQuestion;
import com.atguigu.eduservice.model.entity.QaSecondAnswer;
import com.atguigu.eduservice.service.QaQuestionService;
import com.atguigu.eduservice.service.QaSecondAnswerService;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by corey on 2022/3/31
 **/
@RestController
@RequestMapping("/edu/qa-second-answer")
public class QaSecondAnswerController {

    @Autowired
    private QaSecondAnswerService answerService;

    @Autowired
    private QaQuestionService questionService;

    @ApiOperation(value = "二级回帖")
    @PostMapping("/2Reply")
    public R reply(@RequestBody QaSecondAnswer answer) {
        try {
            answerService.save(answer);
            QaQuestion qaQuestion = questionService.getById(answer.getQuestionId());
            QaQuestion question = new QaQuestion();
            question.setQaComments(qaQuestion.getQaComments()+1);
            question.setId(answer.getQuestionId());
            questionService.updateById(question);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }
}
