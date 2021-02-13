package atm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {

    @Bean
    public DataSource datasource(){

        return new DataSourceDB();
    }

    @Bean
    public Bank bank(){
        return new Bank("My Bank", datasource());
    }

    @Bean
    public ATM atm(){
        return new ATM(bank());
    }

    @Bean
    public AtmUI atmUI(){
        return new  AtmUI(atm());
    }
}
