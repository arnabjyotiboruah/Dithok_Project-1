//package com.dithok.myCommerce.serviceImpl;
//
//import java.util.Optional;
//
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import com.dithok.myCommerce.model.UserModel;
//
//@Service
//public class UsernameAuditorAware implements AuditorAware<String> {
//
//	@Override
//	public Optional<String> getCurrentAuditor() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		 
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return null;
//        }
// 
//        return ((UserModel) authentication.getPrincipal()).getEmail();
//	}

//}
