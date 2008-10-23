/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jchronos.data;

 public enum Priority{
URGENT_AND_IMPORTANT, IMPORTANT_BUT_NOT_URGENT, URGENT_BUT_NOT_IMPORTANT, NEITHER_URGENT_NOR_IMPORTANT;

        @Override
        public String toString() {
            switch(this){
                case URGENT_AND_IMPORTANT:
                    return "Urgent and Important";
                case IMPORTANT_BUT_NOT_URGENT:
                    return "Important but not Urgent";
                case URGENT_BUT_NOT_IMPORTANT:
                    return "Urgent but not Important";
                case NEITHER_URGENT_NOR_IMPORTANT:
                    return "Neither urgent nor Important";
                default:
                    throw new AssertionError("Invalid Priority");
            }
        }
}