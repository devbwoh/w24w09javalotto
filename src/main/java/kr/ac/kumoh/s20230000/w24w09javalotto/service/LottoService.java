package kr.ac.kumoh.s20230000.w24w09javalotto.service;

import kr.ac.kumoh.s20230000.w24w09javalotto.model.LottoNumber;
import kr.ac.kumoh.s20230000.w24w09javalotto.repository.LottoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class LottoService {
    private final LottoRepository lottoRepository;
    private final Random random = new Random();

    public LottoNumber getLuckyNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 6) {
            numbers.add(random.nextInt(1, 46));
        }

        int[] lottoNumbersArray = numbers.stream().sorted().mapToInt(Integer::intValue).toArray();
        LottoNumber lottoNumber = new LottoNumber(lottoNumbersArray);

        return lottoRepository.save(lottoNumber);
    }
}
