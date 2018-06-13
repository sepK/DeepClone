package kaelq.com.deepcloneutil;

import java.io.Serializable;

public class OneSerializable implements Serializable {
    private static final long serialVersionUID = -7060210544600464481L;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public boolean equals(Object obj) {
        OneSerializable o = (OneSerializable) obj;
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
