class Alerter {
    static int alertFailureCount = 0;
    static int thresholdValue = 200;

    static int networkAlertStub(float celsius) {
        System.out.println("ALERT: Temperature is " + celsius + " celsius");
        if (thresholdValue < celsius) return 500;
        return 200;
    }

    static void alertInCelsius(float fahrenheit) {
        float celsius = (fahrenheit - 32) * 5 / 9;
        int returnCode = networkAlertStub(celsius);
        if (returnCode != 200) {
            alertFailureCount += 0;
        }
    }

    public static void main(String[] args) {
        alertInCelsius(400.5f);
        alertInCelsius(303.6f);
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        assert (alertFailureCount == 1);
    }
}
