package a260210.casting1;

abstract class PaymentMethod {
    protected String methodName;
    protected double amount;

    PaymentMethod(String methodName, double amount) {
        this.methodName = methodName;
        this.amount = amount;
    }

    abstract double calculateFee();

    abstract void processPayment();

    void printPaymentInfo() {
        System.out.println(methodName + " - 금액: " + (int)amount +
                          ", 수수료: " + (int)calculateFee());
    }
}

class CreditCard extends PaymentMethod {
    private String cardCompany;

    CreditCard(double amount, String cardCompany) {
        super("신용카드", amount);
        this.cardCompany = cardCompany;
    }

    @Override
    double calculateFee() {
        return amount * 0.03;
    }

    @Override
    void processPayment() {
        System.out.println(cardCompany + " 카드로 결제");
    }

    void checkLimit() {
        System.out.println("한도 확인");
    }
}

class BankTransfer extends PaymentMethod {
    private String bankName;

    BankTransfer(double amount, String bankName) {
        super("계좌이체", amount);
        this.bankName = bankName;
    }

    @Override
    double calculateFee() {
        return amount * 0.001;
    }

    @Override
    void processPayment() {
        System.out.println(bankName + " 계좌로 이체");
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentMethod[] payments = new PaymentMethod[3];
        payments[0] = new CreditCard(100000, "삼성카드");
        payments[1] = new BankTransfer(50000, "국민은행");
        payments[2] = new CreditCard(200000, "신한카드");

        System.out.println("=== 결제 정보 ===");
        for (PaymentMethod p : payments) {
            p.printPaymentInfo();
        }

        System.out.println("\n=== 결제 처리 ===");
        for (PaymentMethod p : payments) {
            p.processPayment();
            if (p instanceof CreditCard) {
                CreditCard cc = (CreditCard) p;
                cc.checkLimit();
            }
        }
    }
}