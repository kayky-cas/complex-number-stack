public class ComplexStack extends Stack<ComplexNumber> {

    private double sqrPlusSqr(double a, double b) {
        return (a * a) + (b * b);
    }

    public void dup() {
        if (isEmpty()) return;

        ComplexNumber number = pop();

        push(number);
        push(number);
    }

    public void swap() {
        if (isEmpty()) return;

        ComplexNumber number1 = pop();

        if (isEmpty()) {
            push(number1);
            return;
        }

        ComplexNumber number2 = pop();

        push(number1);
        push(number2);
    }

    public int size() {
        if (isEmpty())
            return 0;

        return size(1);
    }

    private int size(int cont) {
        ComplexNumber number = pop();

        if (!isEmpty())
            cont = size(++cont);

        push(number);

        return cont;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println();
            return;
        }

        ComplexNumber number = pop();

        System.out.println(number);
        print();

        push(number);
    }

    public void sum() {
        if (isEmpty()) return;
        ComplexNumber number1 = pop();

        if (isEmpty()) {
            push(number1);
            return;
        }
        ComplexNumber number2 = pop();

        double real = number1.real() + number2.real();
        double imaginary = number1.imaginary() + number2.imaginary();

        push(new ComplexNumber(real, imaginary));
    }

    public void sub() {
        if (isEmpty()) return;
        ComplexNumber number1 = pop();

        if (isEmpty()) {
            push(number1);
            return;
        }
        ComplexNumber number2 = pop();

        double real = number1.real() - number2.real();
        double imaginary = number1.imaginary() - number2.imaginary();

        push(new ComplexNumber(real, imaginary));
    }

    public void multi() {
        if (isEmpty()) return;
        ComplexNumber number1 = pop();

        if (isEmpty()) {
            push(number1);
            return;
        }
        ComplexNumber number2 = pop();

        double real = (number1.real() * number2.real()) - (number1.imaginary() * number2.imaginary());
        double imaginary = (number1.real() * number2.imaginary()) + (number1.imaginary() * number1.real());


        push(new ComplexNumber(real, imaginary));
    }

    public void div() {
        if (isEmpty()) return;
        ComplexNumber number1 = pop();

        if (isEmpty()) {
            push(number1);
            return;
        }

        ComplexNumber number2 = pop();

        double divider = sqrPlusSqr(number2.real(), number2.imaginary());

        double real = ((number1.real() * number2.real()) + (number1.imaginary() * number2.imaginary())) / divider;
        double imaginary = ((number2.real() * number1.imaginary()) - (number1.real() * number2.imaginary())) / divider;

        push(new ComplexNumber(real, imaginary));
    }

    public void conj() {
        if (isEmpty()) return;

        ComplexNumber number = pop();

        push(new ComplexNumber(number.real(), -number.imaginary()));
    }

//    public void inv() {
//        if (isEmpty()) return;
//        ComplexNumber number = pop();
//
//        push(new ComplexNumber(sqrPlusSqr(number.real(), number.imaginary()), 0));
//
//        push(number);
//
//        conj();
//
//        div();
//    }

    public void inv() {
        if (isEmpty()) return;

        dup();

        dup();

        conj();

        multi();

        swap();

        conj();

        div();
    }

    public void chs() {
        if (isEmpty()) return;

        ComplexNumber number = pop();

        push(new ComplexNumber(-number.real(), -number.imaginary()));
    }

    public void abs() {
        ComplexNumber number = pop();
        double abs = sqrPlusSqr(number.real(), number.imaginary());

        push(new ComplexNumber(Math.sqrt(abs), 0));
    }
}

