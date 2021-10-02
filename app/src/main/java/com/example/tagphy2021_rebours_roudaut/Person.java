package com.example.tagphy2021_rebours_roudaut;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
/**
 * Class storing data fetched through activities.
 * Must implement Parcelable to be used with Intents.
 * https://developer.android.com/reference/android/os/Parcelable#java
 */
public class Person implements Parcelable {

    //Profile
    private String name;
    private Genre genre;
    private String age;

    //mon coeur
    private Reponse step2Q1;
    private Reponse step2Q2;
    private Reponse step2Q3;
    private Reponse step2Q4;
    private String step2Q5;

    //mon suivi cardiaque
    private Boolean step3Q1;
    private Boolean step3Q2;
    private Boolean step3Q3;

    //imc
    private Reponse step4Q1;
    private String step4Q2Weight;
    private String step4Q3Size;
    private String step4Imc;


    public static final String DEFAULT_NAME = "UNDEFINED";
    public static final String DEFAULT_AGE = "UNDEFINED";
    public static final String DEFAULT_REP = "Yes";
    public static final String DEFAULT_IMC = "UNDEFINED";
    public static final String DEFAULT_WEIGHT = "UNDEFINED";
    public static final String DEFAULT_SIZE = "UNDEFINED";


    /**
     * Constructor. All members get default values
     */
    public Person() {
        this.setName(Person.DEFAULT_NAME);
        this.setGenre(Genre.UNDEFINED);
        this.setAge(Person.DEFAULT_AGE);
        this.setStep2Q1(Reponse.UNDEFINED);
        this.setStep2Q2(Reponse.UNDEFINED);
        this.setStep2Q3(Reponse.UNDEFINED);
        this.setStep2Q4(Reponse.UNDEFINED);
        this.setStep2Q5(Person.DEFAULT_REP);
        this.setStep3Q1(false);
        this.setStep3Q2(false);
        this.setStep3Q3(false);
        this.setStep4Q1(Reponse.UNDEFINED);
        this.setStep4Q2Weight(Person.DEFAULT_WEIGHT);
        this.setStep4Q3Size(Person.DEFAULT_SIZE);
        this.setStep4Imc(Person.DEFAULT_IMC);

    }
    /**
     * @return the description of this class as a String
     */
    @NonNull
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Genre: ").append(this.getGenre()).append("\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        sBuilder.append("\t Heart Condition: ").append(this.getStep2Q1()).append("\n");
        sBuilder.append("\t Cholesterol problem: ").append(this.getStep2Q2()).append("\n");
        sBuilder.append("\t Diabetic: ").append(this.getStep2Q3()).append("\n");
        sBuilder.append("\t Hypertension: ").append(this.getStep2Q4()).append("\n");
        sBuilder.append("\t Parent with had heart problem?: ").append(this.getStep2Q5()).append("\n");
        sBuilder.append("\t Discuss of cardiovascular risk?: ").append(this.getStep3Q1()).append("\n");
        sBuilder.append("\t Cardiac check-up?: ").append(this.getStep3Q2()).append("\n");
        sBuilder.append("\t Have you ever seen a cardiologist?: ").append(this.getStep3Q3()).append("\n");
        sBuilder.append("\t Weight: ").append(this.getStep4Q2Weight()).append("\n");
        sBuilder.append("\t Size: ").append(this.getStep4Q3Size()).append("\n");
        sBuilder.append("\t BMI: ").append(this.getStep4Imc()).append("\n");
        return sBuilder.toString();
    }
    /**
     * Display this instance's contents
     */
    public void print() {
        System.out.println("Person's attributes: ");
        System.out.print(this);
        System.out.println();
    }
/*
 * Getters / Setters
 */
public String getName() { return this.name; }
    public void setName(String aName) { this.name = aName; }
    public Genre getGenre() { return this.genre; }
    public void setGenre(Genre aGenre) { this.genre = aGenre; }
    public String getAge() { return this.age; }
    public void setAge(String anAge) { this.age = anAge; }
    public Reponse getStep2Q1() { return this.step2Q1; }
    public void setStep2Q1(Reponse aStep2Q1) { this.step2Q1 = aStep2Q1; }
    public Reponse getStep2Q2() { return this.step2Q2; }
    public void setStep2Q2(Reponse aStep2Q2) { this.step2Q2 = aStep2Q2; }
    public Reponse getStep2Q3() { return this.step2Q3; }
    public void setStep2Q3(Reponse aStep2Q3) { this.step2Q3 = aStep2Q3; }
    public Reponse getStep2Q4() { return this.step2Q4; }
    public void setStep2Q4(Reponse aStep2Q4) { this.step2Q4 = aStep2Q4; }
    public String getStep2Q5() { return this.step2Q5; }
    public void setStep2Q5(String aStep2Q5) { this.step2Q5 = aStep2Q5; }
    public Boolean getStep3Q1() { return this.step3Q1; }
    public void setStep3Q1(Boolean aStep3Q1) { this.step3Q1 = aStep3Q1; }
    public Boolean getStep3Q2() { return this.step3Q2; }
    public void setStep3Q2(Boolean aStep3Q2) { this.step3Q2 = aStep3Q2; }
    public Boolean getStep3Q3() { return this.step3Q3; }
    public void setStep3Q3(Boolean aStep3Q3) { this.step3Q3 = aStep3Q3; }
    public Reponse getStep4Q1() { return this.step4Q1; }
    public void setStep4Q1(Reponse aStep4Q1) { this.step4Q1 = aStep4Q1; }
    public String getStep4Q2Weight() { return this.step4Q2Weight; }
    public void setStep4Q2Weight(String aStep4Q2Weight) { this.step4Q2Weight = aStep4Q2Weight; }
    public String getStep4Q3Size() { return this.step4Q3Size; }
    public void setStep4Q3Size(String aStep4Q3Size) { this.step4Q3Size = aStep4Q3Size; }
    public String getStep4Imc() { return this.step4Imc; }
    public void setStep4Imc(String aStep4Imc) { this.step4Imc = aStep4Imc; }


    @Override // Parcelable method
    public int describeContents() { return 0;}
    @Override // Parcelable method
    public void writeToParcel(Parcel dest, int flags) {
// Both reading and writing orderings must match (see Person(Parcel in) method)
        dest.writeString(this.getName());
        dest.writeInt(this.getGenre().ordinal());
        dest.writeString(this.getAge());
        dest.writeInt(this.getStep2Q1().ordinal());
        dest.writeInt(this.getStep2Q2().ordinal());
        dest.writeInt(this.getStep2Q3().ordinal());
        dest.writeInt(this.getStep2Q4().ordinal());
        dest.writeString(this.getStep2Q5());
        dest.writeBoolean(this.getStep3Q1());
        dest.writeBoolean(this.getStep3Q2());
        dest.writeBoolean(this.getStep3Q3());
        dest.writeInt(this.getStep4Q1().ordinal());
        dest.writeString(this.getStep4Q2Weight());
        dest.writeString(this.getStep4Q3Size());
        dest.writeString(this.getStep4Imc());


// dest.writeBoolean() requires API 29
// If the error "current min is set to <Number lesser than 29>"
// => Edit Gradle scripts -> build.gradle (Module: YourApp.app)
// ==> change "minSdK <Number lesser than 29>" to "minSdk 29"
// (this SDK must be installed)
        //dest.writeBoolean(this.getCardiacCheckUp());
    }
    /**
     * https://developer.android.com/reference/android/os/Parcelable#java
     */
    public static final Parcelable.Creator<Person> CREATOR
            = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
    /**
     * https://developer.android.com/reference/android/os/Parcelable#java
     */
    private Person(Parcel in) {
// Both reading and writing orderings must match (see writeToParcel method)
        this.setName(in.readString());
        this.setGenre(Genre.values()[in.readInt()]);
        this.setAge(in.readString());
        this.setStep2Q1(Reponse.values()[in.readInt()]);
        this.setStep2Q2(Reponse.values()[in.readInt()]);
        this.setStep2Q3(Reponse.values()[in.readInt()]);
        this.setStep2Q4(Reponse.values()[in.readInt()]);
        this.setStep2Q5(in.readString());
        this.setStep3Q1(in.readBoolean());
        this.setStep3Q2(in.readBoolean());
        this.setStep3Q3(in.readBoolean());
        this.setStep4Q1(Reponse.values()[in.readInt()]);
        this.setStep4Q2Weight(in.readString());
        this.setStep4Q3Size(in.readString());
        this.setStep4Imc(in.readString());
    }
}

