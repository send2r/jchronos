/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jchronos.data;

/**
 *
 * @author ranjith
 */
 public enum Status{
     LIVE,WIP,DONE,CANCELLED;

    @Override
    public String toString() {
        switch(this){
            case LIVE:
                return "Live";
            case WIP:
                return "Work In Progress";
            case DONE:
                return "Complete";
            case CANCELLED:
                return "Cancelled";
            default:
                throw new AssertionError("Unknown Status");
        }
    }

 }
