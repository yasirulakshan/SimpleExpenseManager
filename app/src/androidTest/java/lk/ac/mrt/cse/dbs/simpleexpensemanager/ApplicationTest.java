/*
 * Copyright 2015 Department of Computer Science and Engineering, University of Moratuwa.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *                  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package lk.ac.mrt.cse.dbs.simpleexpensemanager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.ExpenseManager;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.PersistentExpenseManager;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest {
    private static ExpenseManager expenseManager;

    @Before
    public void setupApp(){
        expenseManager = new PersistentExpenseManager(ApplicationProvider.getApplicationContext());
    }

    @Test
    public void addAccountTest(){
        expenseManager.addAccount("1202001","HNB Bank","User 1",21000.00);
        List<String> accountNumbers =  expenseManager.getAccountNumbersList();
        assertTrue(accountNumbers.contains("1202001"));
    }

    @Test
    public void checkNotExistingAccountTest(){
        expenseManager.addAccount("1202005","NSB Bank","User 2",500.00);
        List<String> accountNumbers =  expenseManager.getAccountNumbersList();
        assertFalse(accountNumbers.contains("1202005"));
    }
}