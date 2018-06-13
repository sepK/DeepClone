package kaelq.com.deepclone;

public class One {
    private double number;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        One o = (One) obj;
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        if (this.number != o.getNumber()) {
            return false;
        }
        return true;
    }
}
