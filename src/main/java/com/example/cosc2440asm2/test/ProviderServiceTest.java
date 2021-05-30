package com.example.cosc2440asm2.test;


import com.example.cosc2440asm2.model.Category;
import com.example.cosc2440asm2.model.Provider;
import com.example.cosc2440asm2.service.ProviderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class ProviderServiceTest {
    @Autowired
    public ProviderService providerService;

    @DisplayName("Test Provider create")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testAddProvider() {
        Provider provider = new Provider("new Provider 1");
        int newProviderId = providerService.addProvider(provider);
        assertEquals(providerService.getProviderById(newProviderId).get(0).getName(), provider.getName());
    }

    @DisplayName("Test Provider getAll")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetAllProvider(){
        providerService.addProvider(new Provider("provider 1"));
        providerService.addProvider(new Provider("provider 2"));
        assertEquals(providerService.getAllProviders().size(), 2);
    }

    @DisplayName("Test Provider get by id")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testGetProviderByid(){
        Provider testProvider1 = new Provider("provider 1");
        Provider testProvider2 = new Provider("provider 2");
        int providerId1 = providerService.addProvider(testProvider1);
        int providerId2 = providerService.addProvider(testProvider2);

        assertEquals(providerService.getProviderById(providerId1).get(0).getName(), "provider 1");
    }

    @DisplayName("Test Provider update")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testUpdateProvider(){
        Provider testProvider1 = new Provider("provider 1");
        Provider testProvider2 = new Provider("provider 2");
        int providerId1 = providerService.addProvider(testProvider1);
//        int providerId2 = providerService.addProvider(testProvider2);

        providerService.updateProvider(providerId1, testProvider2);

        assertEquals(providerService.getProviderById(providerId1).get(0).getName(), testProvider2.getName());
    }

    @DisplayName("Test Provider delete")
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    public void testDeleteProvider(){
        Provider testProvider1 = new Provider("provider 1");
        Provider testProvider2 = new Provider("provider 2");
        int providerId1 = providerService.addProvider(testProvider1);
        int providerId2 = providerService.addProvider(testProvider2);

        providerService.deleteProvider(providerId1);
        assertEquals(providerService.getAllProviders().size(), 1);
    }
}
