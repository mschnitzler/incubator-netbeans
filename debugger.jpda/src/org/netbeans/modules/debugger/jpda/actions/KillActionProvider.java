/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.debugger.jpda.actions;

import java.util.Collections;
import java.util.Set;
import org.netbeans.api.debugger.ActionsManager;


import org.netbeans.spi.debugger.ContextProvider;
import org.netbeans.api.debugger.jpda.JPDADebugger;
import org.netbeans.modules.debugger.jpda.JPDADebuggerImpl;
import org.netbeans.spi.debugger.ActionsProvider;


/**
* Representation of a debugging session.
*
* @author   Jan Jancura
*/
@ActionsProvider.Registration(path="netbeans-JPDASession", actions={"kill"})
public class KillActionProvider extends JPDADebuggerActionProvider {


    public KillActionProvider (ContextProvider lookupProvider) {
        super (
            (JPDADebuggerImpl) lookupProvider.lookupFirst 
                (null, JPDADebugger.class)
        );
    }
    
    @Override
    public Set getActions () {
        return Collections.singleton (ActionsManager.ACTION_KILL);
    }
        
    @Override
    public void doAction (Object action) {
        getDebuggerImpl ().finish ();
    }
    
    @Override
    protected void checkEnabled (int debuggerState) {
        setEnabled (ActionsManager.ACTION_KILL, true);
    }
}
