package org.blitmatthew;

import java.util.Objects;

public class Miner {
    private String resource;
    private Integer resourceMined;
    private Thread thread;

    public Miner(String resource, int resourceMined) {
        this.resource = resource;
        this.resourceMined = resourceMined;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public synchronized int getResourceMined() {
        return resourceMined;
    }

    public synchronized void setResourceMined(int resourceMined) {
        this.resourceMined = resourceMined;
    }

    public void startMining() {
        Runnable runnable = () -> {
            while(true){
                resourceMined += 5;
                System.out.println("Miner is mining " + resource);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        thread = new Thread(runnable);
        thread.start();
    }

    public void stopMining() {
        if(thread.isAlive()){
            thread.interrupt();
            System.out.println("The miner has mined: " + resourceMined + " " + resource);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miner miner = (Miner) o;
        return Objects.equals(getResource(), miner.getResource()) && Objects.equals(getResourceMined(), miner.getResourceMined());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResource(), getResourceMined());
    }

    @Override
    public String toString() {
        return "Miner{" +
                "resource='" + resource + '\'' +
                ", resourceMined=" + resourceMined +
                '}';
    }
}
