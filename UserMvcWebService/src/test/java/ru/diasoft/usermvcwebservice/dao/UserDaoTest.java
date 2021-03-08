package ru.diasoft.usermvcwebservice.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ru.diasoft.user_mvc_webservice.dao.UserDaoImpl;
import ru.diasoft.user_mvc_webservice.entities.User;
import ru.diasoft.user_mvc_webservice.rowmapper.UserRowMapper;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Mock
    private NamedParameterJdbcTemplate jdbcTemplate;

    @InjectMocks
    private UserDaoImpl userDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getUserById_ShoudReturnTestUser_WhenInputIsTestId() {
        User expectUser = new User();

        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class),
                Mockito.any(UserRowMapper.class))).thenReturn(expectUser);

        User actual = userDao.getUserById(0);
        Assert.assertEquals(expectUser, actual);
    }

    @Test
    public void getUsersList_ShoudReturnListOfTestUsers() {
        List<User> expected = new ArrayList<User>(Arrays.asList(new User(), new User()));

        Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(UserRowMapper.class))).thenReturn(expected);

        List<User> actual = userDao.getUsersList();
        Assert.assertEquals(expected, actual);
    }
}
