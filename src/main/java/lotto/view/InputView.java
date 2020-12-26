package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SPLIT_REGEX = ",";
    private static final String EMPTY_REGEX = "\\s+";
    Scanner scanner = new Scanner(System.in);

    public long inputPurchaseAmount() {
        return scanner.nextLong();
    }
    public int inputManualCount() {
        return scanner.nextInt();
    }
    public int inputBonusNumber() {
        return scanner.nextInt();
    }

    public List<Lotto> inputManualLottos(int manualCount) {
        scanner.nextLine();
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            List<LottoNumber> manualNumbers = getLottoNumbers();
            lottoList.add(new Lotto(manualNumbers));
        }
        return lottoList;
    }

    public Lotto inputLuckyNumbers() {
        return new Lotto(getLottoNumbers());
    }

    private List<LottoNumber> getLottoNumbers() {
        String[] numbers = scanner.nextLine()
                .replaceAll(EMPTY_REGEX, "")
                .split(SPLIT_REGEX);
        List<LottoNumber> luckyNumbers = new ArrayList<>();
        for (String number : numbers) {
            luckyNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }
        return luckyNumbers;
    }
}
