package com.android.calculator2.evaluation;

import android.support.p002v7.widget.RecyclerView;
import com.p003hp.creals.C0072CR;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;

/* compiled from: PG */
public class BoundedRational {
    public static final BigInteger BIG_FIVE = BigInteger.valueOf(5);
    public static final BigInteger BIG_MINUS_ONE = BigInteger.valueOf(-1);
    public static final int EXTRACT_SQUARE_MAX_LEN = 2000;
    public static final int EXTRACT_SQUARE_MAX_OPT = 43;
    public static final BoundedRational FORTY_FIVE = new BoundedRational(45);
    public static final char FRACTION_SLASH = '⁄';
    public static final BoundedRational HALF = new BoundedRational(1, 2);
    public static final int MAX_SIZE = 10000;
    public static final BoundedRational MINUS_FORTY_FIVE = new BoundedRational(-45);
    public static final BoundedRational MINUS_HALF = new BoundedRational(-1, 2);
    public static final BoundedRational MINUS_NINETY = new BoundedRational(-90);
    public static final BoundedRational MINUS_ONE = new BoundedRational(-1);
    public static final BoundedRational MINUS_QUARTER = new BoundedRational(-1, 4);
    public static final BoundedRational MINUS_SIXTH = new BoundedRational(-1, 6);
    public static final BoundedRational MINUS_THIRD = new BoundedRational(-1, 3);
    public static final BoundedRational MINUS_THIRTY = new BoundedRational(-30);
    public static final BoundedRational MINUS_TWO = new BoundedRational(-2);
    public static final BoundedRational NINETY = new BoundedRational(90);
    public static final BoundedRational ONE = new BoundedRational(1);
    public static final BigInteger[] PRIME_SQUARES = {BigInteger.valueOf(4), BigInteger.valueOf(9), BigInteger.valueOf(25), BigInteger.valueOf(49), BigInteger.valueOf(121), BigInteger.valueOf(169)};
    public static final BoundedRational QUARTER = new BoundedRational(1, 4);
    public static final Random REDUCE_RNG = new Random();
    public static final BoundedRational SIXTH = new BoundedRational(1, 6);
    public static final BigInteger[] SOME_PRIMES = {BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(7), BigInteger.valueOf(11), BigInteger.valueOf(13)};
    public static final String SUPERSCRIPT_MINUS = "⁻";
    public static final BoundedRational TEN = new BoundedRational(10);
    public static final BoundedRational THIRD = new BoundedRational(1, 3);
    public static final BoundedRational THIRTY = new BoundedRational(30);
    public static final BoundedRational THREE = new BoundedRational(3);
    public static final BoundedRational TWELVE = new BoundedRational(12);
    public static final BoundedRational TWO = new BoundedRational(2);
    public static final BoundedRational ZERO = new BoundedRational(0);
    public final BigInteger denominator;
    public final BigInteger numerator;

    public BoundedRational(BigInteger bigInteger, BigInteger bigInteger2) {
        this.numerator = bigInteger;
        this.denominator = bigInteger2;
    }

    public BoundedRational(BigInteger bigInteger) {
        this.numerator = bigInteger;
        this.denominator = BigInteger.ONE;
    }

    public BoundedRational(long j, long j2) {
        this.numerator = BigInteger.valueOf(j);
        this.denominator = BigInteger.valueOf(j2);
    }

    public BoundedRational(long j) {
        this.numerator = BigInteger.valueOf(j);
        this.denominator = BigInteger.ONE;
    }

    public static BoundedRational valueOf(double d) {
        long round = Math.round(d);
        if (((double) round) == d && Math.abs(round) <= 1000) {
            return valueOf(round);
        }
        long doubleToRawLongBits = Double.doubleToRawLongBits(Math.abs(d));
        long j = 4503599627370495L & doubleToRawLongBits;
        int i = (int) (doubleToRawLongBits >>> 52);
        if ((i & 2047) != 2047) {
            long j2 = d < 0.0d ? -1 : 1;
            int i2 = i - 1075;
            if (i == 0) {
                i2++;
            } else {
                j += 4503599627370496L;
            }
            BigInteger valueOf = BigInteger.valueOf(j2 * j);
            BigInteger bigInteger = BigInteger.ONE;
            if (i2 >= 0) {
                valueOf = valueOf.shiftLeft(i2);
            } else {
                bigInteger = bigInteger.shiftLeft(-i2);
            }
            return new BoundedRational(valueOf, bigInteger);
        }
        throw new ArithmeticException("Infinity or NaN not convertible to BoundedRational");
    }

    public static BoundedRational valueOf(long j) {
        if (j >= -2 && j <= 10) {
            int i = (int) j;
            if (i == -2) {
                return MINUS_TWO;
            }
            if (i == -1) {
                return MINUS_ONE;
            }
            if (i == 0) {
                return ZERO;
            }
            if (i == 1) {
                return ONE;
            }
            if (i == 2) {
                return TWO;
            }
            if (i == 10) {
                return TEN;
            }
        }
        return new BoundedRational(j);
    }

    public String toString() {
        String bigInteger = this.numerator.toString();
        String bigInteger2 = this.denominator.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(bigInteger).length() + 1 + String.valueOf(bigInteger2).length());
        sb.append(bigInteger);
        sb.append("/");
        sb.append(bigInteger2);
        return sb.toString();
    }

    public String toNiceString(boolean z, boolean z2) {
        BigInteger bigInteger;
        BoundedRational positiveDen = reduce().positiveDen();
        BigInteger abs = positiveDen.numerator.abs();
        BigInteger bigInteger2 = positiveDen.denominator;
        boolean z3 = positiveDen.numerator.signum() < 0;
        if (positiveDen.denominator.equals(BigInteger.ONE)) {
            bigInteger = BigInteger.ZERO;
        } else if (!z2 || abs.compareTo(bigInteger2) < 0) {
            bigInteger = abs;
            abs = null;
        } else {
            BigInteger[] divideAndRemainder = abs.divideAndRemainder(bigInteger2);
            abs = divideAndRemainder[0];
            bigInteger = divideAndRemainder[1];
        }
        String str = z3 ? (abs != null || !z) ? "-" : SUPERSCRIPT_MINUS : "";
        StringBuilder sb = new StringBuilder(str);
        if (abs != null) {
            sb.append(abs);
        }
        if (bigInteger.signum() == 0) {
            return sb.toString();
        }
        String bigInteger3 = bigInteger.toString();
        String bigInteger4 = bigInteger2.toString();
        if (abs != null) {
            sb.append(" ");
        }
        sb.append(bigInteger3);
        sb.append(z ? Character.valueOf(FRACTION_SLASH) : "/");
        sb.append(bigInteger4);
        return sb.toString();
    }

    public String toNiceString() {
        return toNiceString(false, false);
    }

    public BigInteger[] getNumDen() {
        BoundedRational positiveDen = reduce().positiveDen();
        return new BigInteger[]{positiveDen.numerator, positiveDen.denominator};
    }

    public String toStringTruncated(int i) {
        String bigInteger = this.numerator.abs().multiply(BigInteger.TEN.pow(i)).divide(this.denominator.abs()).toString();
        int length = bigInteger.length();
        int i2 = i + 1;
        if (length < i2) {
            String valueOf = String.valueOf(C0499sj.m9323a('0', i2 - length));
            String valueOf2 = String.valueOf(bigInteger);
            bigInteger = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            length = i2;
        }
        String str = signum() < 0 ? "-" : "";
        int i3 = length - i;
        String substring = bigInteger.substring(0, i3);
        String substring2 = bigInteger.substring(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(substring).length() + String.valueOf(substring2).length());
        sb.append(str);
        sb.append(substring);
        sb.append(".");
        sb.append(substring2);
        return sb.toString();
    }

    public double doubleValue() {
        int i;
        int signum = signum();
        if (signum < 0) {
            return -negate(this).doubleValue();
        }
        int bitLength = this.numerator.bitLength() - this.denominator.bitLength();
        if (bitLength < -1100 || signum == 0) {
            return 0.0d;
        }
        int i2 = bitLength - 80;
        BigInteger bigInteger = this.numerator;
        if (i2 < 0) {
            bigInteger = bigInteger.shiftLeft(-i2);
        }
        BigInteger bigInteger2 = this.denominator;
        if (i2 > 0) {
            bigInteger2 = bigInteger2.shiftLeft(i2);
        }
        BigInteger divide = bigInteger.divide(bigInteger2);
        int bitLength2 = divide.bitLength();
        int i3 = bitLength2 - 53;
        int i4 = i2 + bitLength2;
        if (i4 >= -1021) {
            i = i4 - 1;
        } else {
            i3 += (-1022 - i4) + 1;
            i = -1023;
        }
        BigInteger shiftRight = divide.add(BigInteger.ONE.shiftLeft(i3 - 1)).shiftRight(i3);
        if (i > 1024) {
            return Double.POSITIVE_INFINITY;
        }
        if ((i <= -1023 || shiftRight.bitLength() == 53) && (i > -1023 || shiftRight.bitLength() < 53)) {
            return Double.longBitsToDouble(((((long) i) + 1023) << 52) | (shiftRight.longValue() & 4503599627370495L));
        }
        throw new AssertionError("doubleValue internal error");
    }

    public C0072CR crValue() {
        return C0072CR.valueOf(this.numerator).divide(C0072CR.valueOf(this.denominator));
    }

    public int intValue() {
        BoundedRational reduce = reduce();
        if (reduce.denominator.equals(BigInteger.ONE)) {
            return reduce.numerator.intValue();
        }
        throw new ArithmeticException("intValue of non-int");
    }

    public int wholeNumberBits() {
        if (this.numerator.signum() == 0) {
            return RecyclerView.UNDEFINED_DURATION;
        }
        return this.numerator.bitLength() - this.denominator.bitLength();
    }

    public int bitLength() {
        return this.numerator.bitLength() + this.denominator.bitLength();
    }

    public double apprLog2Abs() {
        int wholeNumberBits = wholeNumberBits();
        if (wholeNumberBits > 10 || wholeNumberBits < -10) {
            return (double) wholeNumberBits;
        }
        double abs = Math.abs(this.numerator.doubleValue() / this.denominator.doubleValue());
        if (Double.isInfinite(abs) || Double.isNaN(abs) || abs == 0.0d) {
            return 0.0d;
        }
        return Math.log(abs) / Math.log(2.0d);
    }

    private boolean tooBig() {
        return !this.denominator.equals(BigInteger.ONE) && this.numerator.bitLength() + this.denominator.bitLength() > 10000;
    }

    private BoundedRational positiveDen() {
        if (this.denominator.signum() > 0) {
            return this;
        }
        return new BoundedRational(this.numerator.negate(), this.denominator.negate());
    }

    public BoundedRational reduce() {
        if (this.denominator.equals(BigInteger.ONE)) {
            return this;
        }
        BigInteger gcd = this.numerator.gcd(this.denominator);
        return new BoundedRational(this.numerator.divide(gcd), this.denominator.divide(gcd));
    }

    private static BoundedRational maybeReduce(BoundedRational boundedRational) {
        if (boundedRational == null) {
            return null;
        }
        if (!boundedRational.tooBig() && (REDUCE_RNG.nextInt() & 15) != 0) {
            return boundedRational;
        }
        BoundedRational reduce = boundedRational.positiveDen().reduce();
        if (!reduce.tooBig()) {
            return reduce;
        }
        return null;
    }

    public int compareTo(BoundedRational boundedRational) {
        int signum = signum();
        int signum2 = boundedRational.signum();
        if (signum > signum2) {
            return 1;
        }
        if (signum < signum2) {
            return -1;
        }
        return this.numerator.multiply(boundedRational.denominator).compareTo(boundedRational.numerator.multiply(this.denominator)) * this.denominator.signum() * boundedRational.denominator.signum();
    }

    public int compareToOne() {
        return this.numerator.compareTo(this.denominator) * this.denominator.signum();
    }

    public int signum() {
        return this.numerator.signum() * this.denominator.signum();
    }

    public int hashCode() {
        BoundedRational positiveDen = reduce().positiveDen();
        return Objects.hash(new Object[]{positiveDen.numerator, positiveDen.denominator});
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof BoundedRational) && compareTo((BoundedRational) obj) == 0;
    }

    public static BigInteger asBigInteger(BoundedRational boundedRational) {
        if (boundedRational == null) {
            return null;
        }
        BigInteger[] divideAndRemainder = boundedRational.numerator.divideAndRemainder(boundedRational.denominator);
        if (divideAndRemainder[1].signum() == 0) {
            return divideAndRemainder[0];
        }
        return null;
    }

    public BigInteger floor() {
        BigInteger[] divideAndRemainder = this.numerator.divideAndRemainder(this.denominator);
        BigInteger bigInteger = divideAndRemainder[0];
        if (divideAndRemainder[1].signum() < 0) {
            return bigInteger.subtract(BigInteger.ONE);
        }
        return bigInteger;
    }

    public static BoundedRational add(BoundedRational boundedRational, BoundedRational boundedRational2) {
        if (boundedRational == null || boundedRational2 == null) {
            return null;
        }
        return maybeReduce(new BoundedRational(boundedRational.numerator.multiply(boundedRational2.denominator).add(boundedRational2.numerator.multiply(boundedRational.denominator)), boundedRational.denominator.multiply(boundedRational2.denominator)));
    }

    public static BoundedRational negate(BoundedRational boundedRational) {
        if (boundedRational == null) {
            return null;
        }
        return new BoundedRational(boundedRational.numerator.negate(), boundedRational.denominator);
    }

    public static BoundedRational subtract(BoundedRational boundedRational, BoundedRational boundedRational2) {
        return add(boundedRational, negate(boundedRational2));
    }

    private static BoundedRational rawMultiply(BoundedRational boundedRational, BoundedRational boundedRational2) {
        if (boundedRational == null || boundedRational2 == null) {
            return null;
        }
        BoundedRational boundedRational3 = ONE;
        if (boundedRational == boundedRational3) {
            return boundedRational2;
        }
        if (boundedRational2 == boundedRational3) {
            return boundedRational;
        }
        return new BoundedRational(boundedRational.numerator.multiply(boundedRational2.numerator), boundedRational.denominator.multiply(boundedRational2.denominator));
    }

    public static BoundedRational multiply(BoundedRational boundedRational, BoundedRational boundedRational2) {
        return maybeReduce(rawMultiply(boundedRational, boundedRational2));
    }

    public static BoundedRational inverse(BoundedRational boundedRational) {
        if (boundedRational == null) {
            return null;
        }
        if (boundedRational.numerator.signum() != 0) {
            return new BoundedRational(boundedRational.denominator, boundedRational.numerator);
        }
        throw new ahb();
    }

    public static BoundedRational divide(BoundedRational boundedRational, BoundedRational boundedRational2) {
        return multiply(boundedRational, inverse(boundedRational2));
    }

    private static BigInteger nthRoot(BigInteger bigInteger, int i) {
        C0072CR cr;
        BigInteger bigInteger2;
        int signum = bigInteger.signum();
        if (signum < 0) {
            if ((i & 1) != 0) {
                return nthRoot(bigInteger.negate(), i).negate();
            }
            throw new ArithmeticException("even root(negative)");
        } else if (signum == 0) {
            return BigInteger.ZERO;
        } else {
            C0072CR valueOf = C0072CR.valueOf(bigInteger);
            if (i == 2) {
                cr = valueOf.sqrt();
            } else if (i == 4) {
                cr = valueOf.sqrt().sqrt();
            } else {
                cr = valueOf.mo5025ln().divide(C0072CR.valueOf(i)).exp();
            }
            BigInteger bigInteger3 = cr.get_appr(-10);
            int intValue = bigInteger3.and(BigInteger.valueOf(1023)).intValue();
            if (intValue != 0 && intValue != 1023) {
                return null;
            }
            if (intValue == 0) {
                bigInteger2 = bigInteger3.shiftLeft(-10);
            } else {
                bigInteger2 = bigInteger3.add(BigInteger.ONE).shiftLeft(-10);
            }
            if (bigInteger2.pow(i).equals(bigInteger)) {
                return bigInteger2;
            }
            return null;
        }
    }

    public static BoundedRational nthRoot(BoundedRational boundedRational, int i) {
        if (boundedRational == null) {
            return null;
        }
        if (i < 0) {
            return inverse(nthRoot(boundedRational, -i));
        }
        BoundedRational reduce = boundedRational.positiveDen().reduce();
        BigInteger nthRoot = nthRoot(reduce.numerator, i);
        BigInteger nthRoot2 = nthRoot(reduce.denominator, i);
        if (nthRoot == null || nthRoot2 == null) {
            return null;
        }
        return new BoundedRational(nthRoot, nthRoot2);
    }

    public static BoundedRational sqrt(BoundedRational boundedRational) {
        return nthRoot(boundedRational, 2);
    }

    private static BigInteger[] extractSquare(BigInteger bigInteger) {
        BigInteger bigInteger2 = BigInteger.ONE;
        if (bigInteger.bitLength() > 2000) {
            return new BigInteger[]{bigInteger2, bigInteger};
        }
        BigInteger bigInteger3 = bigInteger2;
        BigInteger bigInteger4 = bigInteger;
        for (int i = 0; i < SOME_PRIMES.length && !bigInteger4.equals(BigInteger.ONE); i++) {
            while (true) {
                BigInteger[] divideAndRemainder = bigInteger4.divideAndRemainder(PRIME_SQUARES[i]);
                if (divideAndRemainder[1].signum() != 0) {
                    break;
                }
                bigInteger4 = divideAndRemainder[0];
                bigInteger3 = bigInteger3.multiply(SOME_PRIMES[i]);
            }
        }
        int i2 = 1;
        while (true) {
            if (i2 > 10) {
                break;
            }
            long j = (long) i2;
            BigInteger[] divideAndRemainder2 = bigInteger4.divideAndRemainder(BigInteger.valueOf(j));
            if (divideAndRemainder2[1].signum() == 0) {
                BigInteger nthRoot = nthRoot(divideAndRemainder2[0], 2);
                if (nthRoot != null) {
                    bigInteger4 = BigInteger.valueOf(j);
                    bigInteger3 = bigInteger3.multiply(nthRoot);
                    break;
                }
            }
            i2++;
        }
        return new BigInteger[]{bigInteger3, bigInteger4};
    }

    public BoundedRational[] extractSquare() {
        if (signum() == 0) {
            return new BoundedRational[]{ZERO, ONE};
        }
        BoundedRational reduce = positiveDen().reduce();
        BigInteger[] extractSquare = extractSquare(reduce.numerator.abs());
        BigInteger[] extractSquare2 = extractSquare(reduce.denominator);
        if (reduce.numerator.signum() < 0) {
            extractSquare[1] = extractSquare[1].negate();
        }
        return new BoundedRational[]{new BoundedRational(extractSquare[0], extractSquare2[0]), new BoundedRational(extractSquare[1], extractSquare2[1])};
    }

    private BoundedRational rawPow(BigInteger bigInteger) {
        if (bigInteger.equals(BigInteger.ONE)) {
            return this;
        }
        if (bigInteger.and(BigInteger.ONE).intValue() == 1) {
            return rawMultiply(rawPow(bigInteger.subtract(BigInteger.ONE)), this);
        }
        if (bigInteger.signum() == 0) {
            return ONE;
        }
        BoundedRational rawPow = rawPow(bigInteger.shiftRight(1));
        if (!Thread.interrupted()) {
            BoundedRational rawMultiply = rawMultiply(rawPow, rawPow);
            if (rawMultiply == null || rawMultiply.tooBig()) {
                return null;
            }
            return rawMultiply;
        }
        throw new cfj();
    }

    public BoundedRational pow(BigInteger bigInteger) {
        int signum = bigInteger.signum();
        if (signum == 0) {
            return ONE;
        }
        if (bigInteger.equals(BigInteger.ONE)) {
            return this;
        }
        BoundedRational positiveDen = reduce().positiveDen();
        if (positiveDen.denominator.equals(BigInteger.ONE)) {
            if (positiveDen.numerator.equals(BigInteger.ZERO)) {
                return ZERO;
            }
            if (positiveDen.numerator.equals(BigInteger.ONE)) {
                return ONE;
            }
            if (positiveDen.numerator.equals(BIG_MINUS_ONE)) {
                if (bigInteger.testBit(0)) {
                    return MINUS_ONE;
                }
                return ONE;
            }
        }
        if (bigInteger.bitLength() > 1000) {
            return null;
        }
        if (signum < 0) {
            return inverse(positiveDen).rawPow(bigInteger.negate());
        }
        return positiveDen.rawPow(bigInteger);
    }

    public static BoundedRational pow(BoundedRational boundedRational, BoundedRational boundedRational2) {
        if (boundedRational2 == null || boundedRational == null) {
            return null;
        }
        BoundedRational positiveDen = boundedRational2.reduce().positiveDen();
        if (positiveDen.denominator.bitLength() > 30) {
            return null;
        }
        int intValue = positiveDen.denominator.intValue();
        if (intValue == 1) {
            return boundedRational.pow(positiveDen.numerator);
        }
        BoundedRational nthRoot = nthRoot(boundedRational, intValue);
        if (nthRoot == null) {
            return null;
        }
        return nthRoot.pow(positiveDen.numerator);
    }

    public static int digitsRequired(BoundedRational boundedRational) {
        if (boundedRational == null) {
            return Integer.MAX_VALUE;
        }
        int i = 0;
        if (boundedRational.denominator.equals(BigInteger.ONE)) {
            return 0;
        }
        BigInteger bigInteger = boundedRational.reduce().denominator;
        if (bigInteger.bitLength() > 10000) {
            return Integer.MAX_VALUE;
        }
        int i2 = 0;
        while (!bigInteger.testBit(0)) {
            i2++;
            bigInteger = bigInteger.shiftRight(1);
        }
        while (bigInteger.mod(BIG_FIVE).signum() == 0) {
            i++;
            bigInteger = bigInteger.divide(BIG_FIVE);
        }
        if (bigInteger.equals(BigInteger.ONE) || bigInteger.equals(BIG_MINUS_ONE)) {
            return Math.max(i2, i);
        }
        return Integer.MAX_VALUE;
    }
}
