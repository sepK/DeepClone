package kaelq.com.deepcloneutil;

import android.os.Parcel;
import android.os.Parcelable;

public class OneParcelable implements Parcelable {
    private int number;

    public OneParcelable(){

    }
    public OneParcelable(Parcel in) {
        readFromParcel(in);
    }

    @SuppressWarnings("unchecked")
    private void readFromParcel(Parcel in) {
        number = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
    }

    public static final Creator<OneParcelable> CREATOR = new Creator<OneParcelable>() {
        public OneParcelable createFromParcel(Parcel in) {
            return new OneParcelable(in);
        }

        public OneParcelable[] newArray(int size) {
            return new OneParcelable[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public boolean equals(Object obj) {
        OneParcelable o = (OneParcelable) obj;
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
