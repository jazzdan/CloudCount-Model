package cloudcount.models;

import cc.test.bridge.BridgeConstants.State;
import cc.test.bridge.BudgetFactoryInterface;
import cc.test.bridge.BudgetInterface;

/**
 *
 * @author joeycarmello
 */
public class BudgetFactory implements BudgetFactoryInterface {

    /**
     *
     * @return a new budget instance
     */
    @Override
    public BudgetInterface create() {

        Budget budget = new Budget();

        BridgeHelper.getHamper().put(budget, State.CREATE);

        return budget;
    }
}