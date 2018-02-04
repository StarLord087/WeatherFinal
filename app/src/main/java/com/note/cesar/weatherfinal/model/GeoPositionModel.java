package com.note.cesar.weatherfinal.model;

/**
 * Created by shekh on 04-02-2018.
 */

public class GeoPositionModel {

    Integer Version;
    String Key;
    String Type;

    public Integer getVersion() {
        return Version;
    }

    public void setVersion(Integer version) {
        Version = version;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Integer getRank() {
        return Rank;
    }

    public void setRank(Integer rank) {
        Rank = rank;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public void setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public String getPrimaryPostalCode() {
        return PrimaryPostalCode;
    }

    public void setPrimaryPostalCode(String primaryPostalCode) {
        PrimaryPostalCode = primaryPostalCode;
    }

    public GeoPositionModel(Integer version, String key, String type, Integer rank, String localizedName, String englishName, String primaryPostalCode) {
        Version = version;
        Key = key;
        Type = type;
        Rank = rank;

        LocalizedName = localizedName;
        EnglishName = englishName;
        PrimaryPostalCode = primaryPostalCode;
    }

    Integer Rank;
    String LocalizedName, EnglishName, PrimaryPostalCode;

    class Country {
        String ID;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getLocalizedName() {
            return LocalizedName;
        }

        public void setLocalizedName(String localizedName) {
            LocalizedName = localizedName;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String englishName) {
            EnglishName = englishName;
        }

        public Country(String ID, String localizedName, String englishName) {

            this.ID = ID;
            LocalizedName = localizedName;
            EnglishName = englishName;
        }

        String LocalizedName, EnglishName;
    }

    class AdministrativeArea {
        String ID;
        String LocalizedName, EnglishName;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getLocalizedName() {
            return LocalizedName;
        }

        public void setLocalizedName(String localizedName) {
            LocalizedName = localizedName;
        }

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String englishName) {
            EnglishName = englishName;
        }

        public Integer getLevel() {
            return Level;
        }

        public void setLevel(Integer level) {
            Level = level;
        }

        public String getLocalizedType() {
            return LocalizedType;
        }

        public void setLocalizedType(String localizedType) {
            LocalizedType = localizedType;
        }

        public String getEnglishType() {
            return EnglishType;
        }

        public void setEnglishType(String englishType) {
            EnglishType = englishType;
        }

        public String getCountryID() {
            return CountryID;
        }

        public void setCountryID(String countryID) {
            CountryID = countryID;
        }

        public AdministrativeArea(String ID, String localizedName, String englishName, Integer level, String localizedType, String englishType, String countryID) {

            this.ID = ID;
            LocalizedName = localizedName;
            EnglishName = englishName;
            Level = level;
            LocalizedType = localizedType;
            EnglishType = englishType;
            CountryID = countryID;
        }

        Integer Level;
        String LocalizedType, EnglishType, CountryID;
    }

}
