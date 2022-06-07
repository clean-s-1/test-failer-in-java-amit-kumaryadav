class Alerter {
    static int alertFailureCount = 0;

    static final int THRESHOLD_VALUE = 200;

    static final String ENV_TYPE = "DEVELOPMENT";

    enum EnvType {
        DEVELOPMENT, PRODUCTION
    }

    static void alertInCelsius(float fahrenheit) {
        NetworkAlert networkAlert = getNetworkAlert();
        float celsius = (fahrenheit - 32) * 5 / 9;
        int returnCode = networkAlert.alert(celsius, THRESHOLD_VALUE);
        if (returnCode != 200) {
            alertFailureCount += 1;
        }
    }

    private static NetworkAlert getNetworkAlert() {
        NetworkAlert networkAlert = null;
        if (EnvType.DEVELOPMENT.name().equals(ENV_TYPE)) {
            networkAlert = new NetworkAlertStubImpl();
        } else if (EnvType.PRODUCTION.name().equals(ENV_TYPE)) {
            networkAlert = new NetworkAlertImpl();
        }
        return networkAlert;
    }

    public static void main(String[] args) {
        alertInCelsius(400.5f);
        alertInCelsius(303.6f);
        alertInCelsius(500.08f);
        System.out.printf("%d alerts failed.\n", alertFailureCount);
        assert (alertFailureCount == 2);
    }
}

interface NetworkAlert {
    int alert(float celsius, int thresholdValue);
}

class NetworkAlertImpl implements NetworkAlert {

    @Override
    public int alert(float celsius, int thresholdValue) {
        return 0;
    }
}

class NetworkAlertStubImpl implements NetworkAlert {

    @Override
    public int alert(float celsius, int thresholdValue) {
        System.out.println("ALERT: Temperature is " + celsius + " celsius");
        if (thresholdValue < celsius) return 500;
        return 200;
    }
}




