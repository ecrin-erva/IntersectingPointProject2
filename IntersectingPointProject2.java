
package intersectingpointproject2;

import java.util.Scanner;
import java.util.Locale;

public class IntersectingPointProject2 {

    public static class LinearEquation {
        private double a, b, c, d, e, f;

        public LinearEquation(double a, double b, double c,
                              double d, double e, double f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
        }

        public boolean isSolvable() {
            return (a * d - b * c) != 0;
        }

        public double getX() {
            return (e * d - b * f) / (a * d - b * c);
        }

        public double getY() {
            return (a * f - e * c) / (a * d - b * c);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        System.out.print(
            "Enter x1, y1, x2, y2, x3, y3, x4, y4: ");

        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        double a = y1 - y2;
        double b = x2 - x1;
        double c = y3 - y4;
        double d = x4 - x3;
        double e = x2 * y1 - x1 * y2;
        double f = x4 * y3 - x3 * y4;

        LinearEquation equation =
                new LinearEquation(a, b, c, d, e, f);

        if (equation.isSolvable()) {
            double x = equation.getX();
            double y = equation.getY();

            if (x >= Math.min(x1, x2)
                    && x <= Math.max(x1, x2)
                    && y >= Math.min(y1, y2)
                    && y <= Math.max(y1, y2)
                    && x >= Math.min(x3, x4)
                    && x <= Math.max(x3, x4)
                    && y >= Math.min(y3, y4)
                    && y <= Math.max(y3, y4)) {

                System.out.println(
                    "The intersecting point is at ("
                    + x + ", " + y + ")");
            } else {
                System.out.println(
                    "The line segments do not intersect.");
            }
        } else {
            System.out.println(
                "The lines do not have a unique intersection.");
        }

        input.close();
    }
}

