package com.pp.controller;

import com.pp.repositary.WebServiceModel;
import com.pp.repositary.WebServiceRepository;
import com.pp.service.WebSrvService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WebControllerTest {

    @InjectMocks
    private WebSrvService webSrvService;

    @Mock
    private WebServiceRepository webServiceRepository;

    @Test
    public void testAdd()
    {
        WebServiceModel model = new WebServiceModel();
        		model.setUname("jacky");
		        model.setUmail("jacky@gmail.com");
		        model.setUpassword("jacky12334");

        when(webSrvService.saveRecord(model)).thenReturn(model);

        WebServiceModel model1 = webServiceRepository.save(model);

        assertThat(model1.getUname()).isEqualTo(model.getUname());
        assertThat(model1.getUmail()).isEqualTo(model.getUmail());


    }

    @Test
    public void testFindAll()
    {
        // given
        WebServiceModel model = new WebServiceModel();
        model.setUname("Lokesh");
        model.setUmail("howtodoinjava@gmail.com");
        model.setUpassword("1234");

        WebServiceModel model1 = new WebServiceModel();
        model1.setUname("Lokesh1");
        model1.setUmail("howtodoinjava1@gmail.com");
        model1.setUpassword("12345");

        List<WebServiceModel> list = new ArrayList<WebServiceModel>();
        list.add(model);
        list.add(model1);

        when(webServiceRepository.findAll()).thenReturn(list);

        // when
        List<WebServiceModel> result =webServiceRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);

        assertThat(result.get(0).getUname())
                .isEqualTo(model.getUname());

        assertThat(result.get(1).getUname())
                .isEqualTo(model1.getUname());
    }

    @Test
    public void testFindById()
    {
        // given
        WebServiceModel model = new WebServiceModel();
        model.setUid(1);
        model.setUname("Lokesh");
        model.setUmail("howtodoinjava@gmail.com");
        model.setUpassword("1234");

        WebServiceModel model1 = new WebServiceModel();
        model1.setUid(2);
        model1.setUname("Lokesh1");
        model1.setUmail("howtodoinjava1@gmail.com");
        model1.setUpassword("12345");

        WebServiceModel model2= new WebServiceModel();

        List<WebServiceModel> list = new ArrayList<WebServiceModel>();
        list.add(model);
        list.add(model1);

        when(webSrvService.getRecordById(any(Integer.TYPE))).thenReturn(Optional.of(model));

        assertEquals(model,webServiceRepository.findById(1).get());
        assertEquals(model.getUname(),webServiceRepository.findById(1).get().getUname());

            }

            @Test
            public void delete()
            {
                WebServiceModel model = new WebServiceModel();
                model.setUid(1);
                model.setUname("Lokesh");
                model.setUmail("howtodoinjava@gmail.com");
                model.setUpassword("1234");

                when(webServiceRepository.findById(any(Integer.TYPE))).thenReturn(Optional.of(model));
                webSrvService.deleteRecord(1);

                verify(webServiceRepository,timeout(1)).deleteById(1);
            }

}