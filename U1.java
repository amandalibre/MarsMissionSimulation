public class U1 extends Rocket{
    public U1() {
        cost = 100;
        weight = 10000;
        maxWeight = 18000;
    }
    float number =  (float) Math.random() * (float) 0.1;
    boolean chanceOfExplosion() {
        float explosion = .05f * ((float) this.weight/(float) this.maxWeight);
        return (float) Math.random() * (float) 0.1 > explosion;
    }
    @Override
    public boolean launch(){
        return chanceOfExplosion();
    }
    boolean chanceOfCrash() {
        float crash = .01f * (this.weight/this.maxWeight);
        return (float) Math.random() * (float) 0.1 > crash;
    }
    @Override
    public boolean land() {
        return chanceOfCrash();
    }
}
