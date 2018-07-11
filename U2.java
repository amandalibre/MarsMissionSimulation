public class U2 extends Rocket{
    public U2() {
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
    }
    float number =  (float) Math.random() * (float) 0.1;

    boolean chanceOfExplosion() {
        float explosion = .04f * ((float) this.weight/(float) this.maxWeight);
        return (float) Math.random() * (float) 0.1 > explosion;
    }
    @Override
    public boolean launch(){
        return chanceOfExplosion();
    }
    boolean chanceOfCrash() {
        float crash = .08f * (this.weight/this.maxWeight);
        return (float) Math.random() * (float) 0.1 > crash;
    }
    @Override
    public boolean land() {
        return chanceOfCrash();
    }
}