package org.rogue.coder;

/**
 * Created by RogueCoder on 1/12/2017.
 */
public class RCPojo {

    private String foo;
    private String bar;
    private int val;

    public RCPojo(String foo, String bar, int val) {
        this.foo = foo;
        this.bar = bar;
        this.val = val;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "RCPojo{" +
                "foo='" + foo + '\'' +
                ", bar='" + bar + '\'' +
                ", val=" + val +
                '}';
    }
}
