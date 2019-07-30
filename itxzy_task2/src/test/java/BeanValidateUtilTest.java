import com.jnshu.crq.pojo.AddUserRequest;
import com.jnshu.crq.pojo.BeanValidateResult;
import com.jnshu.crq.utils.BeanValidateUtil;
import org.junit.Test;

import java.util.List;

public class BeanValidateUtilTest {
    /**
     * desc :
     * create_user : cheng
     * create_date : 2019/1/23 14:21
     */
    @Test
    public void testValidate() {
        AddUserRequest request = new AddUserRequest();
        request.setAge(-11);

        List<BeanValidateResult> validateResultList = BeanValidateUtil.validate(request);
        for (BeanValidateResult validateResult : validateResultList) {
            System.out.println(validateResult.getFieldName() + " : " + validateResult.getMessage());
        }
    }
}
