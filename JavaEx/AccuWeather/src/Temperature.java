public class Temperature {
    float Value;
    String Unit;
    int UnitType;

    public Temperature(float value, String unit, int unitType) {
        Value = value;
        Unit = unit;
        UnitType = unitType;
    }

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getUnitType() {
        return UnitType;
    }

    public void setUnitType(int unitType) {
        UnitType = unitType;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "Value=" + Value +
                ", Unit='" + Unit + '\'' +
                ", UnitType=" + UnitType +
                '}';
    }
}
