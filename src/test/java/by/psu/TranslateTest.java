package by.psu;

import by.psu.model.postgres.Language;
import by.psu.model.postgres.StringValue;
import by.psu.model.postgres.Translate;
import by.psu.service.api2.LanguageUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranslateTest {

    private Translate translate;
    private List<StringValue> stringValueList = new ArrayList<>();


    @Before
    public void init() {
        translate = new Translate();

        StringValue stringValueRu = new StringValue(Language.RU.getUuid(), "RU", translate);
        StringValue stringValueEn = new StringValue(Language.EN.getUuid(), "EN", translate);

        translate.setValue(stringValueEn);
        translate.setValue(stringValueRu);

        StringValue stringItemValueRu = new StringValue(Language.RU.getUuid(), "RUList", translate);
        StringValue stringItemValueEn = new StringValue(Language.EN.getUuid(), "ENList", translate);
        stringValueList.addAll(Arrays.asList(stringItemValueEn, stringItemValueRu));
    }

    @Test
    public void testSetNewStringValueToTranslateListValue() {
        assertNotNull(translate.getValues());
        assertTrue(LanguageUtil.getValueByLanguage(translate, Language.RU).isPresent());
        assertTrue(LanguageUtil.getValueByLanguage(translate, Language.EN).isPresent());
    }


    @Test
    public void testSetNewStringValueToTranslateListValueWithExistsValue() {
        assertEquals(LanguageUtil.getValueByLanguage(translate, Language.EN).get().getValue(), "EN");

        StringValue stringValueEnNew = new StringValue(Language.EN.getUuid(), "NewEN", translate);

        translate.setValue(stringValueEnNew);

        assertEquals(translate.getValues().size(), 2);
        assertEquals(LanguageUtil.getValueByLanguage(translate, Language.EN).get().getValue(), "NewEN");
        assertTrue(LanguageUtil.getValueByLanguage(translate, Language.RU).isPresent());
        assertTrue(LanguageUtil.getValueByLanguage(translate, Language.EN).isPresent());
    }


    @Test
    public void testSetNewListStringValueToTranslateListValueWithExistsValue() {
        translate.setValues(stringValueList);

        assertEquals(translate.getValues().size(), 2);

        assertTrue(LanguageUtil.getValueByLanguage(translate, Language.RU).isPresent());
        assertTrue(LanguageUtil.getValueByLanguage(translate, Language.EN).isPresent());

        assertEquals(LanguageUtil.getValueByLanguage(translate, Language.EN).get().getValue(), "ENList");
        assertEquals(LanguageUtil.getValueByLanguage(translate, Language.RU).get().getValue(), "RUList");
    }
}