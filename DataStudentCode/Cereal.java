public class Cereal {
    public String name;
    public String type;
    public int calories;
    public int protein;
    public int fat;
    public int sodium;
    public int fiber;
    public int carbs;
    public int sugar;
    public int potassium;
    public int vitamins;
    public int shelf;
    public double weight;
    public double cups;
    public double rating;

    Cereal(String nam, String typ, int calorie, int protei, int fa, int sodiu, int fibe, int carb, int suga, int potassiu, int vitamin, int shel, double weigh, double cup, double ratin) {
        name = nam;
        type = typ;
        calories = calorie;
        protein = protei;
        fat = fa;
        sodium = sodiu;
        fiber = fibe;
        carbs = carb;
        sugar = suga;
        potassium = potassiu;
        vitamins = vitamin;
        shelf = shel;
        weight = weigh;
        cups = cup;
        rating = ratin;
    }

    public String toString() {
        return name + " " + type + " " + calories + " " + protein + " " + fat + " " + sodium + " " + fiber + " " + carbs + " " + sugar + " " + potassium + " " + vitamins + " " + shelf + " " + weight + " " + cups + " " + rating;
    }
}