package lesson1HW;

public enum DayOfWeeks {
    Понедельник (8),
    Вторник (8),
    Среда (8),
    Четверг(8),
    Пятница (8),
    Суббота (0),
    Воскресенье (0);

    int workingHours;

    DayOfWeeks(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }


    }

