package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentTransactionDAO;


/**
 * Created by ASUS on 2016-11-20.
 */
public class PersistentExpenseManager extends ExpenseManager{
    private Context context;

    public PersistentExpenseManager(Context context) {
        this.context=context;
        setup();
    }


    @Override
    public void setup(){

        SQLiteDatabase db = context.openOrCreateDatabase("190690V", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS account(account_no VARCHAR PRIMARY KEY,bank VARCHAR,acc_holder VARCHAR,balance REAL);");


        db.execSQL("CREATE TABLE IF NOT EXISTS transactionLogger(Transaction_id INTEGER PRIMARY KEY, account_no VARCHAR,expense_type INT,amount REAL,transaction_date DATE,FOREIGN KEY (account_no) REFERENCES account(account_no));");

        PersistentAccountDAO accountDAO = new PersistentAccountDAO(db);


        setAccountsDAO(accountDAO);

        setTransactionsDAO(new PersistentTransactionDAO(db));
    }
}
