/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2016 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * 
 * 
 */

package org.wandora.utils;



public class StateTransition extends Object {

    private Object initialState;
    private Object input;
    private Object newState;
    
    

    public StateTransition(Object initialState, Object input, Object newState) {
        this.initialState = initialState;
        this.input = input;
        this.newState = newState;
    }

    // -------------------------------------------------------------------------
    
    public Object getNewState() { return newState; }
    public Object getInput() { return input; }
    public Object getInitialState() { return initialState; }
    
    
    // -------------------------------------------------------------------------
    
    public boolean isValid() {
        if (input != null) return true;
        return false;
    }
    
    public boolean isSelfReference() {
        if (newState == initialState) return true;
        return false;
    }
    

    public boolean isInitial() {
        if (initialState == null) return true;
        return false;
    }
    
    public boolean isFinal() {
        if (newState == null) return true;
        return false;
    }
}
