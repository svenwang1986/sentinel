package com.alibaba.csp.sentinel.dashboard.uniqueid;

public interface IdGenerator<T> {

    /**
     * get next global unique id
     *
     * @return unique id
     */
    T nextId();

}
