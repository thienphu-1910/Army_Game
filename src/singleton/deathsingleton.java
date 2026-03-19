package singleton;

//Sử dụng Singleton Pattern để đảm bảo mỗi observer (DeathCountObserver, DeathNotifierObserver) chỉ có duy nhất một instance trong toàn bộ chương trình.
import observer.DeathCountObserver;
import observer.DeathNotifyObserver;

class DeathSingleton {
    private static DeathSingleton instance;
    private DeathCountObserver deathCountObserver;
    private DeathNotifyObserver deathNotifyObserver;

    private DeathSingleton() {
        deathCountObserver = new DeathCountObserver();
        deathNotifyObserver = new DeathNotifyObserver();
    }

    public static synchronized DeathSingleton getInstance() {
        if (instance == null) {
            instance = new DeathSingleton();
        }
        return instance;
    }

    public DeathCountObserver getDeathCountObserver() {
        return deathCountObserver;
    }

    public DeathNotifyObserver getDeathNotifyObserver() {
        return deathNotifyObserver;
    }
}