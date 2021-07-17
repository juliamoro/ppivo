package plagamedicum.ppvis.lab2s4.Controller;

//Критерий поиска
public enum SearchCriteria{ // перечисления
    LAST_DATE_AND_SNP_CRITERIA("Дата последнего приема и ФИО ветеринара"),
    PET_NAME_AND_BIRTHDAY_CRITERIA("Имя питомца и дата рождения"),
    FRAZE_FROM_DIAGNOSIS_CRITERIA("По фразе из диагноза");
    private final String value;

    SearchCriteria(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
//получить критерии по имени
    public static SearchCriteria getCriteriaByName(String value) {
        SearchCriteria res = null;
        for (SearchCriteria x : values()) { //метод values() возвращает массив из всех хранящихся в Enum значений
            if (x.getValue().equals(value)) { //идет сравнение
                res = x;
            }
        }
        return res;
    }
}
