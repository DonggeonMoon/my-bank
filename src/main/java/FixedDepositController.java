public class FixedDepositController {
    private FixedDepositService fixedDepositService;

    public FixedDepositController(FixedDepositService fixedDepositService) {
        this.fixedDepositService = fixedDepositService;
    }

    public boolean submit() {
        fixedDepositService.save();
        return true;
    }
}
