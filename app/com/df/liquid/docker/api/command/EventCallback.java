package com.df.liquid.docker.api.command;

import com.df.liquid.docker.api.model.Event;





/**
 * Event callback
 */
public interface EventCallback {
    public void onEvent(Event event);
    public void onException(Throwable throwable);
    public void onCompletion(int numEvents);
    public boolean isReceiving();
}