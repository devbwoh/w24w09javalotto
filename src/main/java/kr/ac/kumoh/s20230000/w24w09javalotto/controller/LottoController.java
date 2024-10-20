package kr.ac.kumoh.s20230000.w24w09javalotto.controller;

import kr.ac.kumoh.s20230000.w24w09javalotto.model.LottoNumber;
import kr.ac.kumoh.s20230000.w24w09javalotto.service.LottoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LottoController {
    private final LottoService service;


    @GetMapping("/lotto/numbers")
    public String generateNumbers(Model model) {
        LottoNumber lottoNumber = service.getLuckyNumbers();

        log.info("Number: {}", lottoNumber.numbers());

        model.addAttribute("numbers", lottoNumber.numbers());
        return "lotto";
    }
}