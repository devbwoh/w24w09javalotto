package kr.ac.kumoh.s20230000.w24w09javalotto.repository;

import kr.ac.kumoh.s20230000.w24w09javalotto.model.LottoNumber;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryLottoRepository implements LottoRepository {
    private LottoNumber storedLottoNumber;

    @Override
    public LottoNumber save(LottoNumber lottoNumber) {
        this.storedLottoNumber = lottoNumber;

        return storedLottoNumber;
    }

    @Override
    public LottoNumber find() {
        return storedLottoNumber;
    }
}