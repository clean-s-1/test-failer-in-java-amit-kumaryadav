public class NetworkAlertStubImpl implements NetworkAlert {

    @Override
    public int alert(float celsius, int thresholdValue) {
        System.out.println("ALERT: Temperature is " + celsius + " celsius");
        if (thresholdValue < celsius) return 500;
        return 200;
    }
}
